$( document ).ready(function(){
	console.log("ready!");
	getFilmById(filmId);
});

function getFilmById(filmId){
	$.ajax({
		url: '/moji/api/getFilmById?filmId='+filmId, 
		type: "get",
		dataType: "json",

		success: function(data, textStatus, jqXHR){
			console.log(data);
			$("#title").val(data.title); //แสดงข้อมูลเก่า
			$("#description").val(data.description);
			$("#releaseYear").val(data.releaseYear);
			$("#languageId").val(data.languageId);
			$("#originalLanguageId").val(data.originalLanguageId);
			$("#rentalDuration").val(data.rentalDuration);
			$("#rentalRate").val(data.rentalRate);
			$("#length").val(data.length);
			$("#replacementCost").val(data.replacementCost);
			$("#rating").val(data.rating);
			$("#specialFeatures").val(data.specialFeatures);
			$("#lastUpdate").val(data.lastUpdate);
		}
	});
}

function editFilm(){
	var filmId = window.filmId;
	var title = $("#title").val();
	var description = $("#description").val();
	var releaseYear = $("#releaseYear").val();
	var languageId = $("#languageId").val();
	var originalLanguageId = $("#originalLanguageId").val();
	var rentalDuration = $("#rentalDuration").val();
	var rentalRate = $("#rentalRate").val();
	var length = $("#length").val();
	var replacementCost = $("#replacementCost").val();
	var rating = $("#rating").val();
	var specialFeatures = $("#specialFeatures").val();
	var lastUpdate = $("#lastUpdate").val();
	
	var film = { 
		'filmId' : filmId,
		'title' : title,
		'description' : description,
		'releaseYear' : releaseYear,
		'languageId' : languageId,
		'originalLanguageId' : originalLanguageId,
		'rentalDuration' : rentalDuration,
		'rentalRate' : rentalRate,
		'length' : length,
		'replacementCost' : replacementCost,
		'rating' : rating,
		'specialFeatures' : specialFeatures
	}

		$.ajax({
			url: '/moji/api/editFilm', 
			type: "post",
			asynce : false,
			timeout : 3000,
			data: JSON.stringify(film),
			contentType: "application/json; charset=utf-8",
			success: function(data, textStatus, jqXHR){
				console.log(data);
				window.location.href = '/moji/rest';
			}
		});
	
	return false;
}