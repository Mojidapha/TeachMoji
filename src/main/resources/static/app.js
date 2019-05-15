$( document ).ready(function(){
	console.log("ready!");
	getAllFilm(0, 20, 'G')
});

function getAllFilm(page, size, rating){
	$.ajax({
		url: '/moji/api/allFilms', //ถ้าเข้า url นี้จะได้ข้อมูลออกมาโดยยังไม่เป็นตาราง
		type: "get",
		dataType: "json",

		success: function(data, textStatus, jqXHR){
			console.log(data);

			drawTable(data);
		}
	});
}

function drawTable(data){
	var header = "<thead>"+
	"<tr>" +
	"	<th>Title</th>" +
	"	<th>description</th>" +
  	"	<th>releaseYear</th>" +
  	"	<th>Action</th>" +
  	"	<th>Action</th>" +
  	"</tr>"+
  	" </thead>";
  	
  	$("#filmDisplay").append(header);
  	$("#filmDisplay").append($("<tbody>"));
  	for(var i=0;i<data.length;i++){
  		drawRow(data[i]);
  	}
  	$("#filmDisplay").append($("</tbody>"));
}

function drawRow(rowData){
	var row = $("<tr>");
	$("#filmDisplay").append(row)
	row.append($("<td>" + rowData.title + "</td>"));
	row.append($("<td>" + rowData.description + "</td>"));
	row.append($("<td>" + rowData.releaseYear + "</td>"));
	row.append($("<td><button onclick='edit("+rowData.filmId+");'>Edit</button></td>"));
	row.append($("<td><button onclick='delFilm("+rowData.filmId+");'>Delete</button></td>"));
	row.append($("</tr>"));
}

function edit(filmId){
	window.location.href = '/moji/edit?filmId='+filmId;
}

function delFilm(filmId){
	$.ajax({
			url: '/moji/api/delFilm', 
			type: 'POST',
			asynce : false,
			timeout : 3000,
			data: JSON.stringify(filmId),
			contentType: "application/json; charset=utf-8",
			success: function(data, textStatus, jqXHR){
				console.log(data);
				window.location.href = '/moji/rest';
			}
		});
}

function addFilm(){
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
			url: '/moji/api/addFilm', 
			type: "post",
			data: JSON.stringify(film),
			contentType: "application/json; charset=utf-8",
			success: function(data, textStatus, jqXHR){
				console.log(data);
			}
		});
	
	window.location.href = '/moji/rest';
	console.log(title);
}










