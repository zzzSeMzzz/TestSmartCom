Ext.define('SC.store.StatusStore', {
    extend: 'Ext.data.Store',
    model: 'SC.model.Status',
    autoLoad: true,
    pageSize: 35,
    autoLoad: {start: 0, limit: 35},

    proxy: {
        type: 'ajax',
        api: {
            read : '../../resources/app/app/data/status.json'
        },
        reader: {
            type: 'json',
            root: 'roles',
            successProperty: 'success'
        }
    }
});