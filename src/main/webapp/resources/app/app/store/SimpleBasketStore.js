Ext.define('SC.store.SimpleBasketStore', {
    extend: 'Ext.data.Store',
    model: 'SC.model.SimpleBasket',
    autoLoad: false,
    pageSize: 35,
   // autoLoad: {start: 0, limit: 35},

    proxy: {
        type: 'ajax',
        api: {
            read : '/main/getbasket/',
            destroy : '/main/delbasketitem/'
        },
        reader: {
            type: 'json',
            root: 'items',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true,
            encode: false,
            root: ''
        }
    }
});