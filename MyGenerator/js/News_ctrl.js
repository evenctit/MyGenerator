'use strict';

angular.module('misApp',[]).controller('News', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/News/";
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
							    	$scope.msubject = response.subject
							    	$scope.mcontent = response.content
							    	$scope.mstatus = response.status
							    	$scope.mcreateDate = response.createDate
							    	$scope.mupdateDate = response.updateDate
							    	$scope.mcreateBy = response.createBy
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.msubject = "";
							    	$scope.mcontent = "";
							    	$scope.mstatus = "";
							    	$scope.mcreateDate = "";
							    	$scope.mupdateDate = "";
							    	$scope.mcreateBy = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.subject = $scope.msubject;
					    	data.content = $scope.mcontent;
					    	data.status = $scope.mstatus;
					    	data.createDate = $scope.mcreateDate;
					    	data.updateDate = $scope.mupdateDate;
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
										    										    	data.subject = $scope.msubject;
			    										    	data.content = $scope.mcontent;
			    										    	data.status = $scope.mstatus;
			    										    	data.createDate = $scope.mcreateDate;
			    										    	data.updateDate = $scope.mupdateDate;
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


