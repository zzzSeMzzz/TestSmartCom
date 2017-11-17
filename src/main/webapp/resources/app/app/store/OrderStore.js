Ext.define('SC.store.OrderStore', {
    extend: 'Ext.data.Store',
    model: 'SC.model.Order',
    autoLoad: false,
    pageSize: 35,
    //autoLoad: {start: 0, limit: 35},

    proxy: {
        type: 'ajax',
        api: {
            read : '/main/getorders/',
            //create : '/main/savecustomer',
            update : '/main/updorder/',
            destroy : '/main/delorder/'
        },
        reader: {
            type: 'json',
            root: 'customers',
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