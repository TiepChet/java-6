app = angular.module("user-app",["ngRoute"]);

app.config(function($routeProvider,$locationProvider){
    $locationProvider.hashPrefix('');
    $routeProvider
    .when("/home",{
        templateUrl: "assets/user/home/_home.html",
    })
    .when("/product",{
        templateUrl: "assets/user/product/_product.html",
        controller: "product-crtl"
    })
    .when("/about",{
        templateUrl: "assets/user/about/_about.html",
    })
    .when("/contact-us",{
        templateUrl: "assets/user/contact/_contact.html",
    })
    .when("/shopping-cart",{
        templateUrl: "assets/user/cart/cart-view.html",
        controller: "product-crtl"
    })
    .when("/checkout",{
        templateUrl: "assets/user/cart/checkout.html",
    })
    .when("/login",{
        templateUrl: "assets/login.html",
        controller: "login-controller"
    })
    .otherwise({
        redirectTo: "/home"
    });
});