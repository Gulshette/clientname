
$(document).ready(function(e) {
        $('#season-dropdown').selectpicker({
            dropupAuto: false
        });
        $(".owl-decor-carousel").owlCarousel({

              navigation : true, // Show next and prev buttons
              slideSpeed : 300,
              singleItem:true,
              autoHeight: true

          });


        var val2=$('.walk-around-iframe input[name="walkaroundiframe"]').val();
        $('.walk-around-iframe').append('<iframe id="walk-around-iframe" width="1130" height="614" src="'+ val2 +'" allowfullscreen></iframe>');

        $('.js-read-more').on('click',function(){
            $('.title-paragrap-block.inner-page').toggleClass('autoHeight');
            $(this).hide();
        });


         function galleryHorizontalScroll (){

            var totalBoxWidth = 0;
            if($(window).width() < 768) {
                var totalBox = $('.gallery-section .innerpagegallery-block').length;
                var count  = 0;
                setTimeout(function(){
                    $('.gallery-section .innerpagegallery-block').each(function(){
                    count += 1;
                    var boxWidth = ($(this).outerWidth());
                    totalBoxWidth = totalBoxWidth + boxWidth;
                    console.log("boxWidth: "+boxWidth);
                    if(totalBox == count){

                         if((totalBox % 2) == 0){
                            totalWidth(totalBoxWidth)
                         }
                         if((Math.abs(totalBox % 2)) == 1){
                            totalBoxWidth += boxWidth;
                            totalWidth(totalBoxWidth)
                         }

                    }
                });
                },300);

                function totalWidth(totalBoxWidth){
                        totalBoxWidth = totalBoxWidth / 2;
                        console.log("totalWidth totalBoxWidth: "+totalBoxWidth);
                        $('.innerpagegallery-section > .gallery-section').css({"width":totalBoxWidth+"px","overflow":"auto"});
                        $('.innerpagegallery-section').css({"overflow":"auto"});
                };
            }
        }
        galleryHorizontalScroll();

        if($(window).width() < 768) {
        function readMore (){
            var totalheight = 0;

                setTimeout(function(){
                var totalPara = $('.title-paragrap-block.inner-page').children().length;
                    console.log("totalPara: "+totalPara);
                    $('.title-paragrap-block.inner-page').children().slice(0, 3).each(function(){
                    var childrenHeight = ($(this).outerHeight(true));
                    totalheight = totalheight + childrenHeight;
                    console.log("childrenHeight: "+childrenHeight);
                    if(totalPara >= 3){
                        containerHeightSet(totalheight)
                    }
                });
                },300);
                function containerHeightSet(totalheight){
                        console.log("totalheight: "+totalheight);
                        $('.title-paragrap-block.inner-page').css({"height":totalheight+"px"});
                };
            }

            readMore();
            $(window).resize(function(){
                readMore();
                $('.js-read-more').show();
            });
        };
});