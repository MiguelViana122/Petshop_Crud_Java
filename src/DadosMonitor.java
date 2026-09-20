public class DadosMonitor implements DadosObserver {

    @Override
    public void dadosAlterados() {
        System.out.println("Os dados do sistema foram alterados.");
    }
}