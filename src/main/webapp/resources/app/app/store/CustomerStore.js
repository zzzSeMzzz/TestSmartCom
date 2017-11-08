Ext.define('SC.store.CustomerStore', {
    extend: 'Ext.data.Store',
    model: 'SC.model.Customer',
    autoLoad: true,
    pageSize: 35,
    autoLoad: {start: 0, limit: 35},

    proxy: {
        type: 'ajax',
        api: {
            read : '/main/getcustomers',
            create : '/main/savecustomer',
            update : '/main/savecustomer',
            destroy : '/main/delcustomer'
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