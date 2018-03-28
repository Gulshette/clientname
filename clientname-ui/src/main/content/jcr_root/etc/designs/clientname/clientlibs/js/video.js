$(document).ready(function(e) {
			var val1=$('.video-iframe input[name="youtubeiframe"]').val()+"?rel=0&modestbranding=1&showinfo=0";
			$('.video-iframe').append('<iframe id="youtubeframe" width="1130" height="614" src="'+ val1 +'" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>');

		});