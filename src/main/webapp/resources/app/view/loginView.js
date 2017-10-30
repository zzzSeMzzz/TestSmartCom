Ext.onReady(function(){

    var loginForm=Ext.create('Ext.form.Panel',{
        title: 'Авторизация',
        width: 300,
        height:150,
        bodyPadding:10,
        layout: 'anchor',
        jsonSubmit: true,
        defaults: {
            anchor: '80%'
        },
        renderTo: Ext.getBody(),
        items: [{
            xtype: 'textfield',
            fieldLabel: 'Логин',
            name: 'login'
        },
            {
                xtype: 'textfield',
                name: 'pass',
                fieldLabel: 'Пароль',
                inputType: 'password'
            }],
        buttons: [{
            text: 'Оправить',

            handler: function() {
                loginForm.getForm().submit({
                    headers: {
                        'Content-Type': 'application/json;charset=utf-8'
                    },
                    url: 'login',
                    success: function(form, action){
                        Ext.MessageBox.alert('Авторизация пройдена.',action.result.message);
                    },
                    failure: function(form, action){
                        Ext.MessageBox.alert('Ошибка авторизации.', action.result.message);
                    }
                });
            }
        }]
    });

    loginForm.getEl().center();

});

