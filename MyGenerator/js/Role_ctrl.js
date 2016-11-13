'use strict';

angular.module('misApp',[]).controller('Role', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/Role/";
	$http.get(basicUrl)
	  .success(function (response) {
		  console.log('response:' + response);
		  $scope.list = response.list;
	  });
	$scope.edit = function(type,id) {
		  if (type == 'edit') {
			  $http.get(basicUrl)
			  .success(function (response) {
			    			    	$scope.mid = response.id
							    	$scope.mroleName = response.roleName
							    	$scope.mroleDesc = response.roleDesc
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.mroleName = "";
							    	$scope.mroleDesc = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.roleName = $scope.mroleName;
					    	data.roleDesc = $scope.mroleDesc;
						$http.post(basicUrl,data)
			.success(function (){
				$http.get(basicUrl)
				.success(function (response) {
					$scope.list = response.list;
				});
			});
		}else{
			// update news
			var data = {};
										    										    	data.roleName = $scope.mroleName;
			    										    	data.roleDesc = $scope.mroleDesc;
			    						$http.put(basicUrl,data)
			.success(function (){
				$http.get(basicUrl)
				  .success(function (response) {
					  $scope.list = response.list;
				  });
			});
		}
	};
	
	$scope.remove = function(id) {
		$http.delete(basicUrl)
		.success(function (){
			$http.get(basicUrl)
			  .success(function (response) {
				  $scope.list = response.list;
			  });
		});
	};
});


