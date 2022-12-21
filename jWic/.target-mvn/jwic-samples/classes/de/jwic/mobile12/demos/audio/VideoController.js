{
	/**
	 * Invoked before the element is updated.
	 */ 
	beforeUpdate: function() {
    	//alert("AudioController beforeUpdate");
    	/****
    	var mediaElements = document.querySelectorAll('video, audio'), i, total = mediaElements.length;
    	alert("AudioController afterUpdate mediaElements.length "+total);
   		for (i = 0; i < total; i++) {
   			//alert("AudioController afterUpdate: i "+i);
   			new MediaElementPlayer(mediaElements[i], {
			stretching: stretching,
			pluginPath: '../build/',
			success: function (media) {
					alert("AudioController afterUpdate: media.id " + media.id);
					var renderer = document.getElementById(media.id + '-rendername');
					alert("AudioController afterUpdate: media.id " + media.id + '-rendername');
					media.addEventListener('loadedmetadata', function () {
						var src = media.originalNode.getAttribute('src').replace('&amp;', '&');
						if (src !== null && src !== undefined) {
							renderer.querySelector('.src').innerHTML = '<a href="' + src + '" target="_blank">' + src + '</a>';
							renderer.querySelector('.renderer').innerHTML = media.rendererName;
							renderer.querySelector('.error').innerHTML = '';
						}
					});
	
					media.addEventListener('error', function (e) {
						renderer.querySelector('.error').innerHTML = '<strong>Error</strong>: ' + e.message;
					});
				}
			});
   		}
   		****/
	},
	
	/**
	 * Invoked when the element needs to be updated. If this function returns
	 * false, the existing HTML element is replaced by the rendered part that
	 * comes from the server. If the script is doing the update, it should return
	 * true, to prevent the update.
	 */
	doUpdate: function(element) {
    	//alert("AudioController doUpdate");
	},

	/**
	 * Invoked after the DOM element was updated. This function is NOT updated if
	 * the custom doUpdate function returned true.
	 */
    afterUpdate: function ButtonAfterUpdate(){
    	
    	//alert("VideoController afterUpdate");
    	var mediaElements = document.querySelectorAll('video, audio'), i, total = mediaElements.length;
    	//var mediaElements = document.querySelectorAll('video'), i, total = mediaElements.length;
    	
    	//alert("VideoController afterUpdate mediaElements.length "+total);
    	
    	var audio_id
    	
   		//for (i = 0; i < total; i++) {
   			i = 0;
   			//alert("AudioController afterUpdate: i "+i);
   			new MediaElementPlayer(mediaElements[i], {
			stretching: stretching,
			pluginPath: '../build/',
			success: function (media) {
					//alert("VideoController afterUpdate: i "+i);
					//alert("VideoController afterUpdate: media.id " + media.id);
					
					audio_id = media.id;
					
					var renderer = document.getElementById(media.id + '-rendername');
					//alert("VideoController afterUpdate: media.id " + media.id + '-rendername');
					
					//media.addEventListener('loadedmetadata', function () {
					//	alert("VideoController afterUpdate: media.addEventListener ");
					//	var src = media.originalNode.getAttribute('src').replace('&amp;', '&');
					//	alert("VideoController afterUpdate: src " + src);
					//	if (src !== null && src !== undefined) {
					//		renderer.querySelector('.src').innerHTML = '<a href="' + src + '" target="_blank">' + src + '</a>';
					//		renderer.querySelector('.renderer').innerHTML = media.rendererName;
					//		renderer.querySelector('.error').innerHTML = '';
					//	}
					//});
	
					media.addEventListener('error', function (e) {
						renderer.querySelector('.error').innerHTML = '<strong>Error</strong>: ' + e.message;
					});
				}
			});
			
			try {
				//alert("mediaElements[i].play "+);
				//mediaElements[i].play;
				//alert("mediaElements["+i+"].id "+media.id);
				//media.play;
				//alert("audio_id "+audio_id+"_html5");
				audio_id = audio_id+"_html5";
				//alert("x audio_id "+audio_id);
				var x = document.getElementById(audio_id).play();
				//var x = document.getElementById();
			} catch(err) {
				alert(".play error message "+err.message);
			}

			
			try {
				//alert("before await sleep(1000)");
				//await sleep(1000);
				//alert("after await sleep(1000)");
			} catch(err) {
				alert(".play error message "+err.message);
			}
			
		//}
   		#* debugging *#
   		//var buttons = document.getElementsByTagName("Button");
   		//var buttons = document.getElementById("Button");
   		//alert("AudioController afterUpdate buttons.length "+buttons.length);
   		//document.getElementById("Play").trigger("click");
   		//for ( i=0; i<buttons.length; i++) {
   		//	//alert(buttons[i].id)
   		//	alert("i = "+i);
   		//	tag = document.all(i).tagName;
   		//	alert(tag);
   		//}
    },
	
	/**
	 * Invoked when the existing element is removed from the DOM tree.
	 */
	/***
	destroy: function(element) {
    	alert("AudioController destroy");
	}
	***/
}