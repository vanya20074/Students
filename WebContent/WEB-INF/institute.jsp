<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends List Page</title>
<script src="resources/js/jquery-1.11.0.min.js"></script>
<script src="resources/js/jquery-migrate-1.2.1.min.js"></script>
<script src="resources/js/angular.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var userId = location.search.split('userId=')[1]

	function institutes($scope, $http) {
		$http.get('http://localhost:8080/Stundets/institutes').success(
				function(data) {
					$scope.institutes = data;
				});

	}

	function studentsCount($scope, $http) {
		$http.get('http://localhost:8080/Stundets/studentsCount').success(
				function(data) {
					$scope.studentsCount = data;
				});

		$http.get('http://localhost:8080/Stundets/departmentsCount').success(
				function(data) {
					$scope.departmentsCount = data;
				});
		$http.get('http://localhost:8080/Stundets/institutesCount').success(
				function(data) {
					$scope.institutesCount = data;
				});
	}
</script>
<link rel="stylesheet" type="text/css" href="resources/css/divs.css">
</head>
<body>




	<div class="wrapper">
		<div id="header" ng-controller="studentsCount">
			<ul class="nav nav-pills" role="tablist">
				<li role="presentation"><a href="/Stundets">Students <span
						class="badge">{{studentsCount}}</span>
				</a></li>
				<li role="presentation"><a href="/Stundets/department">Departments
						<span class="badge">{{departmentsCount}}</span>
				</a></li>
				<li role="presentation" class="active"><a
					href="/Stundets/institute">Institutes <span class="badge">{{institutesCount}}</span></a></li>

			</ul>
		</div>


		<div id="middle" ng-controller="institutes">
			<div class="list-group">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search"
						ng-model="query">
				</div>

				<a onclick="" ng-repeat="institute in institutes | filter:query "
					href="" class="list-group-item">{{institute.institute_id}} :
					{{institute.institute}} : {{institute.director}} </a>
			</div>
		</div>
		<div id="footer" class="navbar-static-bottom">dfgfdg1</div>
	</div>

</body>