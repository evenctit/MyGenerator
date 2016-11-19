'use strict';

angular.module('misApp').controller('roleController', function($scope,$http,$window,$location) {
	var baseUrl = "http://" + $location.host() + ":" + $location.port() + "/admins/role/";
	$http.get(baseUrl)
	  .success(function (response) {
		  $scope.roleList = response.list;
		  
		  //åé¡µæ»æ°
		  $scope.pageSize = 10;
		  $scope.pages = Math.ceil($scope.roleList.length / $scope.pageSize); //åé¡µæ°
		  $scope.newPages = $scope.pages > 10 ? 10 : $scope.pages;
		  $scope.pageList = [];
		  $scope.selPage = 1;
		  
		  //è®¾ç½®è¡¨æ ¼æ°æ®æº(åé¡µ)
		  $scope.setData = function () {
			  $scope.items = $scope.roleList.slice(($scope.pageSize * ($scope.selPage - 1)), ($scope.selPage * $scope.pageSize));//éè¿å½åé¡µæ°ç­éåºè¡¨æ ¼å½åæ¾ç¤ºæ°æ®
		  };
		  $scope.items = $scope.roleList.slice(0, $scope.pageSize); 
		  //åé¡µè¦repeatçæ°ç» 
		  		  for (var i = 0; i < $scope.newPages; i++) {
			  $scope.pageList.push(i + 1);
		  }
		  //æå°å½åéä¸­é¡µç´¢å¼
		  $scope.selectPage = function (page) {
			  //ä¸è½å°äº1å¤§äºæå¤§
			  if (page < 1 || page > $scope.pages) return;
			  //æå¤æ¾ç¤ºåé¡µæ°5
			  if (page > 2) {
				//å ä¸ºåªæ¾ç¤º10ä¸ªé¡µæ°ï¼å¤§äº2é¡µå¼å§åé¡µè½¬æ¢
				var newpageList = [];
				for (var i = (page - 3) ; i < ((page + 2) > $scope.pages ? $scope.pages : (page + 2)) ; i++) {
					newpageList.push(i + 1);
				}
				$scope.pageList = newpageList;
			  }
			  $scope.selPage = page;
			  $scope.setData();
			  $scope.isActivePage(page);
			  console.log("éæ©çé¡µï¼" + page);
		  };
		  	//è®¾ç½®å½åéä¸­é¡µæ ·å¼
			$scope.isActivePage = function (page) {
				return $scope.selPage == page;
			};
			//ä¸ä¸é¡µ
			$scope.Previous = function () {
				$scope.selectPage($scope.selPage-1);
			};
			
			$scope.Next = function () {
				$scope.selectPage($scope.selPage);
			};
	  });
	$scope.role_remove = function(id) {
				$http.delete(baseUrl + id)
		.success(function (){
					var ctx = "/admins/";
			$location.path(ctx + 'role'); 
		});
	};
	
	$scope.role_edit = function(id) {
					var ctx = "/admins/";
			$location.path(ctx + 'role/' + id); 
	};
	
	$scope.role_add = function() {
				var ctx = "/admins/";
		$location.path(ctx + 'role/add'); 
	};
});

angular.module('misApp').controller('roleAddController', function($scope,$http,$routeParams,$location) {
	var id = $routeParams.id;
	var baseUrl = "http://" + $location.host() + ":" + $location.port() + "/admins/role/" + id;
	if(typeof(id) != "undefined") {
		$scope.id = id;
		$http.get(baseUrl)
		.success(function (response) {
							$scope.id = response.role.id;
							$scope.roleName = response.role.roleName;
							$scope.roleDesc = response.role.roleDesc;
					});
	}
	
	$scope.role_list = function(){
				var ctx = "/admins/";
		$location.path(ctx + 'role'); 
	};
	
	$scope.role_save = function(){
		var id = $scope.id;
		var baseUrl = "http://" + $location.host() + ":" + $location.port() + "/admins/role/";
		if (typeof(id) == "undefined") { 
			var data = {};
							data.id = $scope.id;
							data.roleName = $scope.roleName;
							data.roleDesc = $scope.roleDesc;
						$http.post(baseUrl , data)
			.success(function (){
								var ctx = "/admins/";
				$location.path(ctx + 'role'); 
			});
		}else{
			var data = {};
							data.id = $scope.id;
							data.roleName = $scope.roleName;
							data.roleDesc = $scope.roleDesc;
						baseUrl = baseUrl + id
			$http.put(baseUrl, data)
			.success(function (){
								var ctx = "/admins/";
				$location.path(ctx + 'role'); 
			});
		}
		
	};
});
