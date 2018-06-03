package com.sandbox50572;

public class Coordinator implements Runnable {

    @Override
    public void run() {

        int id = 1;
        String proxy = null;
        String url = null;
        Thread threadNext = null;

        //TODO Создание и запуск ChromeDriver
        //создание объекта
        Runnable workTo1xBet1 = new WorkTo1xBet(id, proxy, url);
        //создание дочернего потока
        threadNext = new Thread(workTo1xBet1);
        //стартуем новыи поток
        threadNext.start();

        try {
            Thread.sleep(180000);//задержка на 3 минуты
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        //TODO Создание и запуск ChromeDriver
        //создание объекта
        Runnable workTo1xBet2 = new WorkTo1xBet(id, proxy, url);
        //создание дочернего потока
        threadNext = new Thread(workTo1xBet2);
        //стартуем новыи поток
        threadNext.start();
        */
    }
}
