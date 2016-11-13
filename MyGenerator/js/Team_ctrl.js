'use strict';

angular.module('misApp',[]).controller('Team', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/Team/";
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
							    	$scope.mdesc = response.desc
							    	$scope.mdirection = response.direction
							    	$scope.msubjects = response.subjects
							    	$scope.marticles = response.articles
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.mdesc = "";
							    	$scope.mdirection = "";
							    	$scope.msubjects = "";
							    	$scope.marticles = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.desc = $scope.mdesc;
					    	data.direction = $scope.mdirection;
					    	data.subjects = $scope.msubjects;
					    	data.articles = $scope.marticles;
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
										    										    	data.desc = $scope.mdesc;
			    										    	data.direction = $scope.mdirection;
			    										    	data.subjects = $scope.msubjects;
			    										    	data.articles = $scope.marticles;
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


