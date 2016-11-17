'use strict';

angular.module('misApp',[]).controller('ScholarInteraction', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/ScholarInteraction/";
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
							    	$scope.mscholarDate = response.scholarDate
							    	$scope.mscholarName = response.scholarName
							    	$scope.mscholarContent = response.scholarContent
							    	$scope.mcreateBy = response.createBy
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.mscholarDate = "";
							    	$scope.mscholarName = "";
							    	$scope.mscholarContent = "";
							    	$scope.mcreateBy = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.scholarDate = $scope.mscholarDate;
					    	data.scholarName = $scope.mscholarName;
					    	data.scholarContent = $scope.mscholarContent;
					    	data.createBy = $scope.mcreateBy;
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
										    										    	data.scholarDate = $scope.mscholarDate;
			    										    	data.scholarName = $scope.mscholarName;
			    										    	data.scholarContent = $scope.mscholarContent;
			    										    	data.createBy = $scope.mcreateBy;
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


