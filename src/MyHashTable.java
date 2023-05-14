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
        int i = hash(key);
        if(chainArray[i] == null){
            return null;
        }else{
            HashNode<K,V> currentNode = chainArray[i];
            if(currentNode.key.equals(key)){
                return currentNode.value;
            }
            while (currentNode != null) {
                if(currentNode.key.equals(key)){
                    return currentNode.value;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }
    public V remove(K key){
        int i = hash(key);
        if(chainArray[i] == null){
            throw new IndexOutOfBoundsException("There is no such key");
        }else{
            HashNode<K,V> currentNode = chainArray[i];
            if(currentNode.key.equals(key)){
                chainArray[i] = currentNode.next;
            }else{
                HashNode<K,V> previousNode = currentNode;
                while(currentNode != null){
                    if(currentNode.key.equals(key)){
                        previousNode.next = currentNode.next;
                    }
                    previousNode = currentNode;
                    currentNode = currentNode.next;

                }
            }
        }
        return null;
    }
    public boolean contains(V value){
        for(int i = 0; i < chainArray.length; i++){
            if(chainArray[i] == null){
                continue;
            }
            HashNode<K,V> currentNode = chainArray[i];
            if(currentNode.value.equals(value)){
                return true;
            }else{
                while (currentNode.next != null){
                    if(currentNode.value.equals(value)){
                        return true;
                    }
                    currentNode = currentNode.next;
                }
            }

        }
        return false;
    }
    public K getKey(V value){
        for(int i = 0; i < chainArray.length; i++){
            if(chainArray[i] == null){
                continue;
            }
            if (chainArray[i].value.equals(value)){
                return chainArray[i].key;
            }
            HashNode<K,V> currentNode = chainArray[i];
            while (currentNode != null){
                if(currentNode.value.equals(value)){
                    return currentNode.key;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }
}