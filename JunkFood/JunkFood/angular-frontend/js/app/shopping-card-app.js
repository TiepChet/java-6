
app.controller("shopping-cart", function ($scope, $http, $routeParams, $route) {

    $scope.products = [];
    $scope.categories = [];
    $scope.form = {};

    $scope.initalize = function () {

        $http.get("http://localhost:8080/api/product?page=0&page_size=10")
            .then(function successCallback(response) {
                $scope.products = response.data;
                // $scope.product.forEach(item =>{
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




    $scope.cart = {
        items: [],

        create(id) {
            var item = this.items.find(item => item.id == id);

            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`http://localhost:8080/api/product/${id}`).then(response => {
                    response.data.qty = 1;
                    this.items.push(response.data);
                    this.saveToLocalStorage();
                    console.log("loi");
                }).catch(error => {
                    console.log(error);
                })
            }
        },

        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },

        loadFromLocalStorage() {
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }

    }
    $scope.cart.loadFromLocalStorage();

})