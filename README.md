# IdentService

Система бронирования отелей

## Описание

Веб-приложение для бронирования номеров в отелях с клиент-серверной архитектурой. Предоставляет пользователям возможность просматривать доступные номера, бронировать их, оставлять отзывы и управлять своими бронированиями. Администраторы могут управлять номерами и бронированиями через специальную панель.

## Функциональные возможности

1. **Авторизация и регистрация пользователей**: реализована система аутентификации с использованием JWT.
2. **Личный кабинет пользователя**:
    - Просмотр забронированных номеров
    - Управление избранными номерами
    - Редактирование личной информации
3. **Панель администратора**:
    - Управление номерами (добавление, редактирование, удаление)
    - Просмотр и управление бронированиями
4. **Страница доступных номеров**:
    - Поиск
    - Сортировка
    - Фильтрация
    - Пагинация
5. **Страница отдельного номера**:
    - Просмотр подробной информации
    - Бронирование номера
    - Оставление отзывов
    - Система лайков и рейтингов

## Запуск проекта локально

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/Advancedboy/IdentService
