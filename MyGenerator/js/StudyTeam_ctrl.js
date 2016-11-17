'use strict';

angular.module('misApp',[]).controller('StudyTeam', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/StudyTeam/";
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
							    	$scope.mstudyDirection = response.studyDirection
							    	$scope.msubjectsTask = response.subjectsTask
							    	$scope.mrelativeArticles = response.relativeArticles
							    	$scope.mtype = response.type
							    	$scope.mteamGroupName = response.teamGroupName
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.mdesc = "";
							    	$scope.mstudyDirection = "";
							    	$scope.msubjectsTask = "";
							    	$scope.mrelativeArticles = "";
							    	$scope.mtype = "";
							    	$scope.mteamGroupName = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.desc = $scope.mdesc;
					    	data.studyDirection = $scope.mstudyDirection;
					    	data.subjectsTask = $scope.msubjectsTask;
					    	data.relativeArticles = $scope.mrelativeArticles;
					    	data.type = $scope.mtype;
					    	data.teamGroupName = $scope.mteamGroupName;
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
			    										    	data.studyDirection = $scope.mstudyDirection;
			    										    	data.subjectsTask = $scope.msubjectsTask;
			    										    	data.relativeArticles = $scope.mrelativeArticles;
			    										    	data.type = $scope.mtype;
			    										    	data.teamGroupName = $scope.mteamGroupName;
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


