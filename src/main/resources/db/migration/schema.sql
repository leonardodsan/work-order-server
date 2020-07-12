
    create table customer (
       id uuid not null,
        created_at timestamp not null,
        updated_at timestamp,
        address varchar(255),
        mail varchar(255),
        name varchar(255) not null,
        phone varchar(255),
        primary key (id)
    )

    create table device (
       id uuid not null,
        created_at timestamp not null,
        updated_at timestamp,
        alias varchar(255) not null,
        manufacturer varchar(255),
        type varchar(255),
        primary key (id)
    )

    create table professional (
       id uuid not null,
        created_at timestamp not null,
        updated_at timestamp,
        name varchar(255) not null,
        profession varchar(255),
        primary key (id)
    )

    create table work_order (
       id uuid not null,
        created_at timestamp not null,
        updated_at timestamp,
        end_moment timestamp,
        problem varchar(255) not null,
        start_moment timestamp,
        status int4 not null,
        accountable_id uuid,
        customer_id uuid not null,
        device_id uuid not null,
        primary key (id)
    )

    create table work_order_ocurrence (
       id uuid not null,
        created_at timestamp not null,
        updated_at timestamp,
        description varchar(255) not null,
        work_order_id uuid not null,
        primary key (id)
    )

    alter table work_order 
       add constraint FKhki3flcyygrjwjtjggmnqtbn0 
       foreign key (accountable_id) 
       references professional

    alter table work_order 
       add constraint FKt0bw3op1441q7wxibmxsk5ekv 
       foreign key (customer_id) 
       references customer

    alter table work_order 
       add constraint FKs75wdytey2wrk95liwy3i2ips 
       foreign key (device_id) 
       references device

    alter table work_order_ocurrence 
       add constraint FK7i6n25ypbe47flq2qk1sr2gfx 
       foreign key (work_order_id) 
       references work_order
