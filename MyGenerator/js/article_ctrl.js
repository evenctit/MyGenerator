'use strict';

angular.module('misApp',['ngRoute']).config(function($routeProvider){
	$routeProvider
	.when('/', {
        templateUrl : '/admins/login.html',
        controller  : 'loginController'
    })
    .when('/admins/news', {
        templateUrl : '/admins/news_list.html',
        controller  : 'newsController'
    })
    .when('/admins/news/add', {
        templateUrl : '/admins/news_add.html',
        controller  : 'newsController'
    })
    .when('/admins/news/:id', {
        templateUrl : '/admins/news_add.html',
        controller  : 'newsController'
    })
    ;
    
    
});

