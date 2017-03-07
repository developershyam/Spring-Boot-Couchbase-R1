SpringApp.factory("BaseService", function($http) {

	return {

		getBooks : function($scope, currentPage) {
			pageLoaderAPI(true);
			$.get(contextPath + "/getBooks?currentPage=" + currentPage,
					function(dataWrapper, status) {
				
						pageLoaderAPI(false);
						$scope.$apply(function() {
							$scope.dataWrapper = dataWrapper;
							if ($scope.dataWrapper && $scope.dataWrapper.data
									&& $scope.dataWrapper.data.length > 0) {
								$("#bookPaginationFooter").unbind();
								bookPaginationFooter(dataWrapper.pageNumber,
										dataWrapper.pageSize,
										dataWrapper.totalPages,
										dataWrapper.totalElement);
							} else {
								$('#bookPaginationFooter').html('');

							}
						});

					});
		},
		addBook : function($scope) {
			var book = $scope.newBook;
			if (!hasValueStr(book.name) || !hasValueStr(book.author)) {
				alert("Book Name & Author can not be blank!");
				return;
			}
			if (!validateEmail(book.email)) {
				alert("Email invalid!");
				return;
			}
			pageLoaderAPI(true);
			$.ajax({
				headers : {
					"Accept" : "application/json",
					"Content-Type" : "application/json",
				},
				type : "POST",
				url : "addBook",
				data : JSON.stringify(book),
				dataType : "json",
				success : function(response) {
					pageLoaderAPI(false);
					if (response.httpStatus == 200) {
						$scope.getBooks(0);
						$scope.$apply(function() {
							$scope.newBook = {
								id : null,
								name : "",
								author : "",
								email : ""
							};
						});

					} else {
						alert(response.message);
					}

				},
				error : function(e) {
					alert("error");
					pageLoaderAPI(false);
				},
				done : function(e) {
					alert("done");
					pageLoaderAPI(false);
				}
			});
		},

		updateBook : function($scope, book) {

			if (!hasValueStr(book.name) || !hasValueStr(book.author)) {
				alert("Book Name & Author can not be blank!");
				return;
			}
			if (!validateEmail(book.email)) {
				alert("Email invalid!");
				return;
			}
			pageLoaderAPI(true);
			$.ajax({
				headers : {
					"Accept" : "application/json",
					"Content-Type" : "application/json",
				},
				type : "PUT",
				url : "updateBook",
				data : JSON.stringify(book),
				dataType : "json",
				success : function(response) {
					pageLoaderAPI(false);
					if (response.httpStatus == 200) {
						$scope.getBooks(0);
					} else {
						alert(response.message);
					}

				},
				error : function(e) {
					alert("error");
					pageLoaderAPI(false);
				},
				done : function(e) {
					alert("done");
					pageLoaderAPI(false);
				}
			});
		},
		deleteBook : function($scope, book) {

			pageLoaderAPI(true);
			$.ajax({
				headers : {
					"Accept" : "application/json",
					"Content-Type" : "application/json",
				},
				type : "DELETE",
				url : "deleteBook/" + (book.bookId),
				// data : JSON.stringify(book),
				dataType : "json",
				success : function(response) {
					pageLoaderAPI(false);
					if (response.httpStatus == 200) {
						$scope.getBooks(0);
					} else {
						alert(response.message);
					}

				},
				error : function(e) {
					alert("error");
					pageLoaderAPI(false);
				},
				done : function(e) {
					alert("done");
					pageLoaderAPI(false);
				}
			});
		},

	};
});

SpringApp.controller('ManagementController', [ '$scope', '$http',
		'BaseService', '$timeout',
		function($scope, $http, BaseService, $timeout) {

			$scope.dataShow = "";

			getManagementData(firstURL);
		} ]);

SpringApp.controller('BookController', [ '$scope', '$http', 'BaseService',
		'$timeout', function($scope, $http, BaseService, $timeout) {

			$scope.bookList = [];
			BaseService.getBooks($scope, 0);

			$scope.newBook = {
				id : null,
				name : "",
				author : "",
				email : ""
			};
			$scope.checkEmail = function(email) {

				// alert(data);
				if (!validateEmail(email)) {
					return 'Email invalid!';
				}
			};

			$scope.getBooks = function(currentPage) {
				BaseService.getBooks($scope, currentPage);
			};

			$scope.addBook = function() {
				BaseService.addBook($scope);
			};

			$scope.updateBook = function(book) {
				BaseService.updateBook($scope, book);
			};

			$scope.deleteBook = function(book) {
				BaseService.deleteBook($scope, book);
			};

		} ]);