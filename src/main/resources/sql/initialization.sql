INSERT INTO public.role_entity(id, name)
  VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO public.user_entity(id, email, login, name, password)
  VALUES (1, 'admin@admin', 'admin', 'Administrator', '$2a$10$XJHseSi571cqKixxz7GJ0e9zZdfss7xOSzFSoUnvqXseed7qO13Fu');

INSERT INTO public.user_entity_roles(user_entity_id, roles_id)
  VALUES (1, 2);