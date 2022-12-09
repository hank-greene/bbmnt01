{
	/**
	 * Invoked before the element is updated.
	 */ 
	beforeUpdate: function() {
    	//alert("AudioController beforeUpdate");
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
    	
    	//alert("AudioController afterUpdate");
    	var mediaElements = document.querySelectorAll('video, audio'), i, total = mediaElements.length;
    	
    	//alert("AudioController afterUpdate mediaElements.length "+total);
    	var audio_id
    	
   		//for (i = 0; i < total; i++) {
   			i = 0;
   			//alert("AudioController afterUpdate: i "+i);
   			new MediaElementPlayer(mediaElements[i], {
			stretching: stretching,
			pluginPath: '../build/',
			success: function (media) {
					//alert("AudioController afterUpdate: i "+i);
					//alert("AudioController afterUpdate: media.id " + media.id);
					
					audio_id = media.id;
					
					var renderer = document.getElementById(media.id + '-rendername');
					//alert("AudioController afterUpdate: media.id " + media.id + '-rendername');
					
					//media.addEventListener('loadedmetadata', function () {
					//	var src = media.originalNode.getAttribute('src').replace('&amp;', '&');
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
				//alert( "audio_id.duration "+ x );
				//alert( "audio_id "+audio_id+"_html5" );
				audio_id = audio_id+"_html5";
				//alert( "x audio_id brefore play " + audio_id );
				
				//var m = parseInt( document.getElementById(audio_id).duration / 60, 10 );
				//var s = document.getElementById(audio_id).duration % 60;
				//alert(" minute " + m " seconds " + s);
				var d = document.getElementById(audio_id).duration;
				//alert(" duration "+d);
				var h = parseInt( d / 3600, 10 );
				//alert(" hours " + h );
				var m = parseInt( d / 60, 10 );
				//alert(" minutes " + m );
				var s = d % 60;
				//alert(" seconds " + s );
				var x = document.getElementById(audio_id).play();
				
				//var x = document.getElementById();
			} catch(err) {
				//alert(".play error message "+err.message);
			}
			
			try {
				
				//alert("before getElementsByTagName");
				//var d = document.getElementsByTagName('mediaelementwrapper');
				//var k = d.childNodes.length;
				//alert("after getElementsByTagName  k (length)"+k);
				
			} catch(err) {
				alert(".play error message "+err.message);
			}
   		//}
   		#* debugging *#
    },
	
	/**
	 * Invoked when the existing element is removed from the DOM tree.
	 */
	destroy: function(element) {
    	//alert("AudioController destroy");
	}
}