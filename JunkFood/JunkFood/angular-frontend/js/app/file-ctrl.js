const app = angular.module("app", []);

app.controller("ctrl", function($scope, $http){
    var url = `http://localhost:8080/rest/files/images`;
    
    $scope.url = function(filename){
        return `${url}/${filename}`;
    }

    $scope.list = function(){
        $http.get(url).then(response =>{
            $scope.filenames = response.data;
            console.log($scope.filenames)
        }).catch(error =>{
            console.log("Errors", error);
        })
    }

    $scope.upload = function(files){
        // tạo ra đối tương form data
        var form = new FormData();

        // duyệt qua tất cả các files
        for (var i = 0; i < files.length; i++) {
            form.append("files", files[i]);
        }

        $http.post(url, form, {
            transformRequest: angular.indentity,
            headers: {'Content-Type': undefined}
        }).then(response=>{
            $scope.filenames.push(response.data);
        }).catch(error=>{
            console.log("Errors:", error);
        })
        
    }

    $scope.delete = function(filename){
        $http.delete(`${url}/${filename}`).then(response=>{
            // tìm trong mảng filenames có tên giống tên với người dung đưa vào
            let i = $scope.filenames.findIndex(name => name == filename);
            $scope.filenames.splice(i,1);
        }).catch(error=>{
            console.log("Error", error);
        })
    }

    $scope.list();

})