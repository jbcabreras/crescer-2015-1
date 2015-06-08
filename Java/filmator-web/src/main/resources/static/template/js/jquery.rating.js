(function($) {
  var buildRating = function(obj) {
    var rating = averageRating(obj),
        obj    = buildInterface(obj),
        stars  = $("div.star", obj),
        cancel = $("div.cancel", obj),
        valor 

        var fill = function() {
          drain();
          $("a", stars).css("width", "100%");
		  el = stars.index(this) + 1;
          for(x = 0; x < el; x++)
				stars.eq(x).addClass("hover");
		  //stars.lt(stars.index(this) + 1).addClass("hover");
        },
        drain = function() {
          stars.removeClass("on").removeClass("hover");
        },
        reset = function() {
          drain();
          el = rating[0];
		  for(x = 0; x < el; x++)
			stars.eq(x).addClass("on");
        },
        cancelOn = function() {
          drain();
          $(this).addClass("on");
        },
        cancelOff = function() {
          reset();
          $(this).removeClass("on")
        }

    stars
      .hover(fill, reset).focus(fill).blur(reset)
      .click(function() {

        $('se')
        
        var idFilme = $( this ).parent().attr('idFilme');
        var nota = $( this ).find('a').text();
        var idUsuario = $( this ).parent().attr('name');

         $.ajax({
                    url: '/template/nota?pontos=' + nota + '&idFilme=' + idFilme + '&idUsuario=' + idUsuario,
                    type: 'POST'
                });

        stars.unbind().addClass("done");
        $(this).css("cursor", "default");
        return false;
      });

    reset();
    return obj;

  }

  var buildInterface = function(form) {
    var container = $("<div></div>").attr({"title": form.title, "class": form.className, "idFilme": $(form).attr('idFilme')});
    $.extend(container, {url: form.action})
    var optGroup  = $("option", $(form));
	var input  = $("input", $(form));
    var size      = optGroup.length;
    optGroup.each(function() {
      container.append($('<div class="star"><a " href="#' + this.value + '" title="Give it ' + this.value + '/'+ size +'">' + this.value + '</a></div>'));
    });
    $(form).after(container).remove();
    return container;
  }

  var averageRating = function(el) { return el.title.split(":")[1].split(".") }

  $.fn.rating = function() { return $($.map(this, function(i) { return buildRating(i)[0] })); }

	if ($.browser) try { document.execCommand("BackgroundImageCache", false, true)} catch(e) { }

})(jQuery)