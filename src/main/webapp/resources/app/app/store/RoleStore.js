Ext.define('SC.store.RoleStore', {
    extend: 'Ext.data.Store',
    model: 'SC.model.Role',
    autoLoad: true,
    pageSize: 35,
    autoLoad: {start: 0, limit: 35},

    proxy: {
        type: 'ajax',
        api: {
            read : '../../resources/app/app/data/roles.json'
        },
        reader: {
            type: 'json',
            root: 'roles',
            successProperty: 'success'
        }
    }
});