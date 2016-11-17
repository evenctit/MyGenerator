'use strict';

angular.module('misApp',[]).controller('BioSpecification', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/BioSpecification/";
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
							    	$scope.mbasicInfo = response.basicInfo
							    	$scope.mprojectProgressBrifeDes = response.projectProgressBrifeDes
							    	$scope.mbioCatId = response.bioCatId
							    	$scope.mbasicVideoDesPath = response.basicVideoDesPath
							    	$scope.mprojectProgressDetailDes = response.projectProgressDetailDes
							    	$scope.mdatabaseId = response.databaseId
							    	$scope.mrelativeActicleId = response.relativeActicleId
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.mbasicInfo = "";
							    	$scope.mprojectProgressBrifeDes = "";
							    	$scope.mbioCatId = "";
							    	$scope.mbasicVideoDesPath = "";
							    	$scope.mprojectProgressDetailDes = "";
							    	$scope.mdatabaseId = "";
							    	$scope.mrelativeActicleId = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.basicInfo = $scope.mbasicInfo;
					    	data.projectProgressBrifeDes = $scope.mprojectProgressBrifeDes;
					    	data.bioCatId = $scope.mbioCatId;
					    	data.basicVideoDesPath = $scope.mbasicVideoDesPath;
					    	data.projectProgressDetailDes = $scope.mprojectProgressDetailDes;
					    	data.databaseId = $scope.mdatabaseId;
					    	data.relativeActicleId = $scope.mrelativeActicleId;
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
										    										    	data.basicInfo = $scope.mbasicInfo;
			    										    	data.projectProgressBrifeDes = $scope.mprojectProgressBrifeDes;
			    										    	data.bioCatId = $scope.mbioCatId;
			    										    	data.basicVideoDesPath = $scope.mbasicVideoDesPath;
			    										    	data.projectProgressDetailDes = $scope.mprojectProgressDetailDes;
			    										    	data.databaseId = $scope.mdatabaseId;
			    										    	data.relativeActicleId = $scope.mrelativeActicleId;
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


