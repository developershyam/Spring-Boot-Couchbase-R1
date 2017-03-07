$(document).ready(function() {

	$('.mlistUL li').click(function() {
		$(this).siblings('li').removeClass('active');
		$(this).addClass('active');
	});
});
$.ajaxSetup({
	beforeSend : function(xhr) {
		xhr.setRequestHeader('X-CSRF-TOKEN', token);
	}
});

function pageLoader(value) {
	if (value) {
		$("#pageLoader").show();
	} else {
		$("#pageLoader").hide();
	}
}

function pageLoaderAPI(value) {
	if (value) {
		$("#pageLoaderAPI").show();
	} else {
		$("#pageLoaderAPI").hide();
	}
}

function validateEmail(email) {
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

function stringToBoolean(string) {
	if (hasValue(string)) {
		switch (string.toLowerCase().trim()) {
		case "true":
		case "yes":
		case "1":
			return true;
		case "false":
		case "no":
		case "0":
		case null:
			return false;
		default:
			return Boolean(string);
		}
	}
	return false;
}

function hasValueStr(val) {
	if (val != null && val != undefined && val.toString().trim() != '') {
		return true;
	}
	return false;
}

function stringContains(string, substring) {
	if (string && substring && string.indexOf(substring) > -1) {
		return true;
	}
	return false;
}

function stringContainsIgnoreCase(string, substring) {
	if (string && substring
			&& string.toUpperCase().indexOf(substring.toUpperCase()) > -1) {
		return true;
	}
	return false;
}

function hasValueStrLenEQ(val, charLen) {
	if (val != null && val != undefined && val.toString().trim() != ''
			&& val.toString().trim().length == charLen) {
		return true;
	}
	return false;
}

function hasValueStrLenLT(val, charLen) {
	if (val != null && val != undefined && val.toString().trim() != ''
			&& val.toString().trim().length < charLen) {
		return true;
	}
	return false;
}
function hasValueStrLenEQGT(val, charLen) {
	if (val != null && val != undefined && val.toString().trim() != ''
			&& val.toString().trim().length >= charLen) {
		return true;
	}
	return false;
}

function hasValueOpt(val) {
	if (val != null && val != undefined && val.toString().trim() != ''
			&& val.toString().trim() != "-1" && val.toString().trim() != "0") {
		return true;
	}
	return false;
}

function hasValueAllOpt(val) {
	if (val != null && val != undefined && val.toString().trim() != ''
			&& val.toString().trim() == "0") {
		return true;
	}
	return false;
}

function hasValue(val) {
	// Executes if val is not null, not undefined, not 0, and not empty string,
	// not false
	if (val) {
		return true;
	}
	return false;
}

function bookPaginationFooter(pageNumber, pageSize, totalPages,
		totalElement) {

	var maxVisiblePages = totalPages;
	if (parseInt(totalPages) > 5) {
		maxVisiblePages = 5;
	}
	$('#bookPaginationFooter').bootpag({
		total : totalPages,
		page : pageNumber,
		maxVisible : maxVisiblePages,
		leaps : true,
		firstLastUse : true,
		first : 'FIRST',
		last : 'LAST',
		next : 'NEXT',
		prev : 'PREV',
		wrapClass : 'pagination',
		activeClass : 'active',
		disabledClass : 'disabled',
		nextClass : 'next',
		prevClass : 'prev',
		lastClass : 'last',
		firstClass : 'first'
	}).on(
			"page",
			function(event, currentPage) {
				getNgService("BaseService").getBooks(
						getNgScope("bookController"), currentPage);
			});
}
