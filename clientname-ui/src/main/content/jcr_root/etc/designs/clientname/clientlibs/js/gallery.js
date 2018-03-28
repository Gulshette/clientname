		    $(document).ready(function(e) {

		     $('.js-preview-image').on('click', function(){
            		    	var imgUrl = $(this).find('img').attr('src');
            		    	console.log("imgUrl:"+imgUrl);
            	    		$('#preview_image').attr('src',imgUrl);
            	    		$('.previewModal').modal('show');
            		    });


		      function galleryHorizontalScroll (){
		     	var totalBoxWidth = 0;
		     	if($(window).width() < 768) {
				    var totalBox = $('.gallery-section .innerpagegallery-block').length;
				    var count  = 0;
				    setTimeout(function(){
			    		$('.gallery-section .innerpagegallery-block').each(function(){
				    	count += 1;
			    		var boxWidth = ($(this).outerWidth() + 20);
			    		totalBoxWidth = totalBoxWidth + boxWidth;
			    		console.log("boxWidth: "+boxWidth);
			    		if(totalBox == count){
			    			totalWidth(totalBoxWidth)
			    		}
				    });
				    },200);

				    function totalWidth(totalBoxWidth){
					    	totalBoxWidth = totalBoxWidth / 2;
					    	console.log("totalWidth totalBoxWidth: "+totalBoxWidth);
					    	$('.innerpagegallery-section > .gallery-section').css({"width":totalBoxWidth+"px"});
					    	$('.innerpagegallery-section').css({"overflow":"auto"});
				    };
			    }
		    }
		    galleryHorizontalScroll();
		    });