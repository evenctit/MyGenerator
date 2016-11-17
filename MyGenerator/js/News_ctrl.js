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
							    	$scope.mpublishDate = response.publishDate
							    	$scope.macticalId = response.acticalId
							    	$scope.macticalLink = response.acticalLink
							    	$scope.macticalAuthor = response.acticalAuthor
							  });
		    } else {
		    				    	$scope.mid = "";
							    	$scope.msubject = "";
							    	$scope.mcontent = "";
							    	$scope.mstatus = "";
							    	$scope.mcreateDate = "";
							    	$scope.mupdateDate = "";
							    	$scope.mcreateBy = "";
							    	$scope.mpublishDate = "";
							    	$scope.macticalId = "";
							    	$scope.macticalLink = "";
							    	$scope.macticalAuthor = "";
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
					    	data.publishDate = $scope.mpublishDate;
					    	data.acticalId = $scope.macticalId;
					    	data.acticalLink = $scope.macticalLink;
					    	data.acticalAuthor = $scope.macticalAuthor;
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
			    										    	data.publishDate = $scope.mpublishDate;
			    										    	data.acticalId = $scope.macticalId;
			    										    	data.acticalLink = $scope.macticalLink;
			    										    	data.acticalAuthor = $scope.macticalAuthor;
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


