Ext.define('SC.store.ItemStore', {
    extend: 'Ext.data.Store',
    model: 'SC.model.Item',
    autoLoad: true,
    pageSize: 35,
    autoLoad: {start: 0, limit: 35},

    proxy: {
        type: 'ajax',
        api: {
            read : '/main/getitems',
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
            root: 'items'
        }
    }
});