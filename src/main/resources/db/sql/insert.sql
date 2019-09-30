INSERT INTO money_types (id, money_label) VALUES (1, 'TRY');
INSERT INTO money_types (id, money_label) VALUES (2, 'GBP');

INSERT INTO user(username,password,enabled) VALUES ('mkyong','$2b$10$K1CiqcM5nSw9LTK.r8Wz0O3NGQKSUCgXHfuUjggVf0e0zHLJGReC2', true);
INSERT INTO user(username,password,enabled) VALUES ('alex','$2b$10$K1CiqcM5nSw9LTK.r8Wz0O3NGQKSUCgXHfuUjggVf0e0zHLJGReC2', true);
INSERT INTO user(username,password,enabled) VALUES ('admin','$2b$10$K1CiqcM5nSw9LTK.r8Wz0O3NGQKSUCgXHfuUjggVf0e0zHLJGReC2', true);

--$2b$10$K1CiqcM5nSw9LTK.r8Wz0O3NGQKSUCgXHfuUjggVf0e0zHLJGReC2

INSERT INTO user_roles (username, role) VALUES ('mkyong', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('mkyong', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES ('alex', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('admin', 'ROLE_ADMIN');



INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ('my-client', '', 'my-secret', 'foo,read,write, password,authorization_code,refresh_token', null, null, 36000, 36000, null, true);


