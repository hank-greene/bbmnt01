/*
{
	// Attach to events...
	afterUpdate: function(element) {
	#if($control.visible)
		var btn = JWic.$('btn_${control.controlID}');
		if (btn) {
			JWic.controls.Button.initialize(btn, "${control.controlID}",$control.buildJsonOptions());
		}
	#end
	}
}
*/
{
    afterUpdate : function ButtonAfterUpdate(){
        var button = JWic.$('$control.controlID'),
            options = $control.buildJsonOptions();
        JWic.mobile.Button.initialize(button, options);
    },
	
	/**
	 * Invoked when the existing element is removed from the DOM tree.
	 */
	destroy : function(element) {
		var button = JWic.$('$control.controlID');
		JWic.mobile.Button.destroy(button);
	}
}
