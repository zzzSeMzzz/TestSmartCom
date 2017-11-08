Ext.define('SC.model.User', {
    extend: 'Ext.data.Model',
    fields: ['id', 'login', 'password', 'role', 'idCustomer', 'idRole', 'nameCustomer']
});