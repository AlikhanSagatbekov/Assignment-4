public class MyHashTable<K,V> {
    private class HashNode <K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    private int hash(K key){ // generating char from a key
        String strKey = (String) key;
        int sum = 0;
        for(int i = 0; i < strKey.length(); i++){
            sum += strKey.charAt(i);
        }

        return sum % M;
    }
    public void put(K key, V value){
        int i = hash(key);
        HashNode<K,V> node = new HashNode<K,V>(key, value);

        if(chainArray[i] == null){
            chainArray[i] = node;
            size++;
        }else{
            HashNode<K,V> currentNode = chainArray[i];
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = node;
            size++;
        }
        if(M/size < 0.7){
            M*=2;
            HashNode<K,V>[] newChainArray = new HashNode[M];
            for(int j = 0; j < chainArray.length; j++){
                newChainArray[j] = chainArray[j];
            }
            chainArray = newChainArray;
        }
    }
    public V get(K key){
        return null;
    }
    public V remove(K key){
        return null;
    }
    public boolean contains(V value){

        return false;
    }
    public K getKey(V value){
        return null;
    }
}