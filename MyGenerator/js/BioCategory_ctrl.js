'use strict';

angular.module('misApp',[]).controller('BioCategory', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/BioCategory/";
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
							    	$scope.mbioCatName = response.bioCatName
							    	$scope.mbioCatDes = response.bioCatDes
							    	$scope.mbioParentId = response.bioParentId
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.mbioCatName = "";
							    	$scope.mbioCatDes = "";
							    	$scope.mbioParentId = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.bioCatName = $scope.mbioCatName;
					    	data.bioCatDes = $scope.mbioCatDes;
					    	data.bioParentId = $scope.mbioParentId;
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
										    										    	data.bioCatName = $scope.mbioCatName;
			    										    	data.bioCatDes = $scope.mbioCatDes;
			    										    	data.bioParentId = $scope.mbioParentId;
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


