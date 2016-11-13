'use strict';

angular.module('misApp',[]).controller('Article', function($scope, $http) {
	var basicUrl = "http://localhost:8080/admin/Article/";
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
							    	$scope.mcreateDate = response.createDate
							    	$scope.mcreateBy = response.createBy
							    	$scope.mupdateDate = response.updateDate
							    	$scope.mupdateBy = response.updateBy
							    	$scope.mstatus = response.status
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.msubject = "";
							    	$scope.mcontent = "";
							    	$scope.mcreateDate = "";
							    	$scope.mcreateBy = "";
							    	$scope.mupdateDate = "";
							    	$scope.mupdateBy = "";
							    	$scope.mstatus = "";
						  }
	};
	
	$scope.add = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {};
					    	data.id = $scope.mid;
					    	data.subject = $scope.msubject;
					    	data.content = $scope.mcontent;
					    	data.createDate = $scope.mcreateDate;
					    	data.createBy = $scope.mcreateBy;
					    	data.updateDate = $scope.mupdateDate;
					    	data.updateBy = $scope.mupdateBy;
					    	data.status = $scope.mstatus;
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
			    										    	data.createDate = $scope.mcreateDate;
			    										    	data.createBy = $scope.mcreateBy;
			    										    	data.updateDate = $scope.mupdateDate;
			    										    	data.updateBy = $scope.mupdateBy;
			    										    	data.status = $scope.mstatus;
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


