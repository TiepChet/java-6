// const app = angular.module("login-app", []);

app.controller("login-controller", function ($scope, $http) {

    $scope.form = {};

    // const url = "http://localhost:8080/api/auth/login";

    $scope.login = function () {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/api/auth/login',
            data: {
                username: $scope.username,
                password: $scope.password
            }
        }).then(response => {
            Swal.fire({
                icon: 'success',
                title: 'Đăng nhập thành công!',
                text: 'Quay lại trang chủ!',
            });
        })

        // $http.post(url, data).then(response => {
        //     Swal.fire({
        //         icon: 'success',
        //         title: 'Đăng nhập thành công!',
        //         text: 'Quay lại trang chủ!',
        //     });
        //     window.location.href = "#home";
        // }).catch(error => {
        //     console.log(error);
        // })

    }

});