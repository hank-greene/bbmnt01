{
	/**
	 * Invoked before the element is updated.
	 */ 
	beforeUpdate: function() {
    	alert("AudioController beforeUpdate");
	},
	
	/**
	 * Invoked when the element needs to be updated. If this function returns
	 * false, the existing HTML element is replaced by the rendered part that
	 * comes from the server. If the script is doing the update, it should return
	 * true, to prevent the update.
	 */
	doUpdate: function(element) {
    	alert("AudioController doUpdate");
	},

	/**
	 * Invoked after the DOM element was updated. This function is NOT updated if
	 * the custom doUpdate function returned true.
	 */
    afterUpdate: function ButtonAfterUpdate(){
    	
    	alert("AudioController afterUpdate");
    	var mediaElements = document.querySelectorAll('video, audio'), i, total = mediaElements.length;
    	
    	//alert("AudioController afterUpdate mediaElements.length "+total);
    	var audio_id
    	
        i = 0;
        //alert("AudioController afterUpdate: i "+i);
        new MediaElementPlayer(mediaElements[i], {
            stretching: stretching,
            pluginPath: '../build/',
            success: function (media) {

                audio_id = media.id;
                
                var renderer = document.getElementById(media.id + '-rendername');

                media.addEventListener('error', function (e) {
                    renderer.querySelector('.error').innerHTML = '<strong>Error</strong>: ' + e.message;
                });
            }
        });
        
        try {
            audio_id = audio_id+"_html5";
            var d = document.getElementById(audio_id).duration;
            var h = parseInt( d / 3600, 10 );
            var m = parseInt( d / 60, 10 );
            var s = d % 60;
            var x = document.getElementById(audio_id).play();
        } catch(err) {
            //alert(".play error message "+err.message);
        }
        
        try {
            var d = document.getElementsByTagName('mediaelementwrapper');
            var k = d.childNodes.length;
        } catch(err) {
            //alert(".play error message "+err.message);
        }
    },
	
	/**
	 * Invoked when the existing element is removed from the DOM tree.
	 */
	destroy: function(element) {
    	alert("AudioController destroy");
	}
}