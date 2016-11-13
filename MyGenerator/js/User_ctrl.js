'use strict';

angular.module('misApp',[]).controller('User', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/User/";
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
							    	$scope.musername = response.username
							    	$scope.mpassword = response.password
							    	$scope.mstatus = response.status
							    	$scope.mdesc = response.desc
							    	$scope.mteamId = response.teamId
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.musername = "";
							    	$scope.mpassword = "";
							    	$scope.mstatus = "";
							    	$scope.mdesc = "";
							    	$scope.mteamId = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.username = $scope.musername;
					    	data.password = $scope.mpassword;
					    	data.status = $scope.mstatus;
					    	data.desc = $scope.mdesc;
					    	data.teamId = $scope.mteamId;
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
										    										    	data.username = $scope.musername;
			    										    	data.password = $scope.mpassword;
			    										    	data.status = $scope.mstatus;
			    										    	data.desc = $scope.mdesc;
			    										    	data.teamId = $scope.mteamId;
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


