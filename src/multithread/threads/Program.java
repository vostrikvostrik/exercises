package multithread.threads;

/**
 * User: User
 * Date: 11.09.17
 * Time: 12:45
 */

/**
 * Incremenator — поток, который каждую секунду прибавляет или вычитает единицу из значения статической переменной Program.mValue
 * */
class Incremenator extends Thread
{
    //О ключевом слове volatile - чуть ниже:
    //В объявлении переменных mIsIncrement и mFinish было использовано ключевое слово volatile (изменчивый, не постоянный).
    // Его необходимо использовать для переменных, которые используются разными потоками.
    // Это связано с тем, что значение переменной, объявленной без volatile, может кэшироваться отдельно для каждого потока,
    // и значение из этого кэша может различаться для каждого из них.
    // Объявление переменной с ключевым словом volatile отключает для неё такое кэширование
    // и все запросы к переменной будут направляться непосредственно в память.

    private volatile boolean mIsIncrement = true;
    private volatile boolean mFinish = false;

    public void changeAction()	//Меняет действие на противоположное
    {
        mIsIncrement = !mIsIncrement;
    }
    public void finish()		//Инициирует завершение потока
    {
        mFinish = true;
    }

    @Override
    public void run()
    {
        do
        {
            if(!mFinish)	//Проверка на необходимость завершения
            {
                if(mIsIncrement)
                    Program.mValue++;	//Инкремент
                else
                    Program.mValue--;	//Декремент

                //Вывод текущего значения переменной
                System.out.print(Program.mValue + " ");
            }
            else
                return;		//Завершение потока

            try{
                Thread.sleep(1000);		//Приостановка потока на 1 сек.
            }catch(InterruptedException e){}
        }
        while(true);
    }
}

public class Program
{
    //Переменая, которой оперирует инкременатор
    public static int mValue = 0;

    static Incremenator mInc;	//Объект побочного потока

    public static void main(String[] args)
    {
        mInc = new Incremenator();	//Создание потока

        System.out.print("Значение = ");

        mInc.start();	//Запуск потока

        //Троекратное изменение действия инкременатора
        //с интервалом в i*2 секунд
        for(int i = 1; i <= 3; i++)
        {
            try{
                Thread.sleep(i*2*1000); //Ожидание в течении i*2 сек.
            }catch(InterruptedException e){}

            mInc.changeAction();	//Переключение действия
        }

        mInc.finish();	//Инициация завершения побочного потока
    }
}
