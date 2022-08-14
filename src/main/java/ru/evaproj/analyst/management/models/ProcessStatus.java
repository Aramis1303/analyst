package ru.evaproj.analyst.management.models;
/*
 * REQUESTED - Запрошено со стороны клиента (Со стороны клиента)
 * OPENED - Открыт запрос на сделку (Со стороны торг. терминала)
 * PERFORMED - Исполнено запрос на сделку (Со стороны торг. терминала)
 * CLOSING - Запрос на закрытие сделки (Со стороны клиента)
 * CLOSED - Исполнено закрытие сделки (Со стороны торг. терминала)
 * CANCELING - Запрос на отмену выставленного запроса на сделку (Со стороны клиента)
 * CANCELED - Исполнена отмена запроса на сделку (Со стороны торг. терминала)
 * REJECTED - Отклонён запро системой  (Со стороны торг. терминала)
**/
public enum ProcessStatus {
    REQUESTED, OPENED, PERFORMED, CLOSING, CLOSED, CANCELING, CANCELED, REJECTED
}
