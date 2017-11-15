Ext.define('SC.store.UserStore', {
    extend: 'Ext.data.Store',
    model: 'SC.model.User',
    autoLoad: true,
    pageSize: 35,
    autoLoad: {start: 0, limit: 35},

    proxy: {
        type: 'ajax',
        api: {
            read : '/main/getusersadv',
            create : '/main/saveuseradv',
            update : '/main/saveuseradv',
            destroy : '/main/deluser'
        },
        reader: {
            type: 'json',
            root: 'users',
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