'use strict';

angular.module('misApp',[]).controller('DataAnalyze', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/DataAnalyze/";
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
							    	$scope.mdataAnalyzeCatId = response.dataAnalyzeCatId
							    	$scope.mdataAnalyzeTitle = response.dataAnalyzeTitle
							    	$scope.mdataAnalyzeLink = response.dataAnalyzeLink
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.mdataAnalyzeCatId = "";
							    	$scope.mdataAnalyzeTitle = "";
							    	$scope.mdataAnalyzeLink = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.dataAnalyzeCatId = $scope.mdataAnalyzeCatId;
					    	data.dataAnalyzeTitle = $scope.mdataAnalyzeTitle;
					    	data.dataAnalyzeLink = $scope.mdataAnalyzeLink;
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
										    										    	data.dataAnalyzeCatId = $scope.mdataAnalyzeCatId;
			    										    	data.dataAnalyzeTitle = $scope.mdataAnalyzeTitle;
			    										    	data.dataAnalyzeLink = $scope.mdataAnalyzeLink;
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


