'use strict';

angular.module('misApp',[]).controller('Bio', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/Bio/";
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
							    	$scope.mflmc = response.flmc
							    	$scope.mtSwmcId = response.tSwmcId
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.mflmc = "";
							    	$scope.mtSwmcId = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.flmc = $scope.mflmc;
					    	data.tSwmcId = $scope.mtSwmcId;
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
    										    	data.flmc = $scope.mflmc;
			    										    	data.tSwmcId = $scope.mtSwmcId;
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


