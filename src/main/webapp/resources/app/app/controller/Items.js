Ext.define('SC.controller.Items', {
    extend: 'Ext.app.Controller',

    views: ['ItemList', 'Item'],
    
    models: ['Item'],
        init: function() {
            this.control({
                'viewport > itemlist': {

                },
                'itemwindow button[action=new]': {

                },
                'itemwindow button[action=save]': {

                },
                'itemwindow button[action=delete]': {

                },
                'itemwindow button[action=clear]': {
                    click: this.clearForm
                }
            });
        },

    clearForm: function(grid, record) {
        var view = Ext.widget('bookwindow');
        view.down('form').getForm().reset();
    }
});