app.controller("product-crtl", function ($scope, $http, $routeParams, $route) {
  $scope.products = [];
  $scope.categories = [];
  $scope.form = {};

  $scope.initalize = function () {

    $http.get("http://localhost:8080/api/product?page=0&page_size=10")
      .then(function successCallback(response) {
        $scope.products = response.data;
        // $scope.products.forEach(item =>{
        //   // chuyển đổi ngày tháng dữ liệu được tải sang javascrip
        //   item.create_date = new Date(item.create_date);
        // })
        console.log($scope.products);
      },
        function errorCallback(response) {
          console.log("Unable to perform get request");
        })

    $http.get("http://localhost:8080/api/category?page=0&page_size=10")
      .then(function successCallback(response) {
        $scope.categories = response.data;
        console.log($scope.categories);
      },
        function errorCallback(response) {
          console.log("Unable to perform get request");
        })
  }

  $scope.fi = function(cid){
    var url = getFullUrl(
      'https://domain.com/registry?{cid}',
      {
        cid: $scope.cid,
      }
    );
    $http.get({
      method: 'GET',
      url: url
    }).then(function (res) {
      alert("succssee")
    });
  }

  $scope.initalize();

  $scope.cart = {
    items: [],
    // thêm sản phẩm vào giỏ hàng
    add(id) {
      // kiểm tra xem mặt hàng đã có hay không
      var item = this.items.find(item => item.id == id);

      // nếu có tăng số lương lên
      if (item) {
        item.qty++;
        this.saveToLocalStorage();
      }
      else {
        // tải sản phẩm ở trên service về thông qua một API
        $http.get(`http://localhost:8080/api/product/${id}`).then(response => {
          response.data.qty = 1; // thiết lập số lượng bằng 1
          this.items.push(response.data);// add vào mảng items
          this.saveToLocalStorage();
          Swal.fire({
            title: "Add to cart success",
            text: "You clicked the button!",
            icon: "success",
            button: "OK!",
          });
        })
      }
    },

    //xóa sản phẩm khỏi giỏ hàng
    remove(id) {
      // tìm vị trí sản phẩm nằm trong giỏ hàng
      var index = this.items.findIndex(item => item.id == id);

      this.items.splice(index, 1);
      this.saveToLocalStorage();
    },
    // xóa sạch các mặt hàng trong giỏ
    clear() {
      this.items = [];
      this.saveToLocalStorage();

      Swal.fire({
        title: "Clear cart success",
        text: "You clicked the button!",
        icon: "success",
        button: "OK!",
      });
    },

    get count() {
      return this.items
        .map(item => item.qty)
        .reduce((total, qty) => total += qty, 0);
    },

    get amount() {
      return this.items
        .map(item => item.qty * item.price)
        .reduce((total, qty) => total += qty, 0);
    },

    saveToLocalStorage() {
      // đổi cái mảng items(sản phẩm) sang json
      var json = JSON.stringify(angular.copy(this.items));

      // dùng chuỗi json lưu vào localStorage với tên là cart
      localStorage.setItem("cart", json);
    },

    // đọc giỏ hang từ local storage
    loadFromLocalStorage() {
      // đọc lại cart trong localstore
      var json = localStorage.getItem("cart");

      //nếu có chuyển sang json
      //nếu không có chuyển sang [] rỗng
      // gán vào items
      this.items = json ? JSON.parse(json) : [];
    },

  }

  $scope.cart.loadFromLocalStorage();




})