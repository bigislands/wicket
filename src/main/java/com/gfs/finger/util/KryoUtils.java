package com.gfs.finger.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.BeanSerializer;
import com.pspot.wicket.vo.LatentImageBean;

public class KryoUtils {

    private static Kryo kryo = new Kryo();

    public static <T> byte[]  registerKryo(T t){
        Output output = null;
        try{
            kryo.register(t.getClass(),new BeanSerializer(kryo,t.getClass()));
            output = new Output(128,10240000);
            kryo.writeObject(output,t);
        }finally {
            output.close();
        }
        return output.toBytes();
    }

    public static LatentImageBean deserializer(byte[] bytes, LatentImageBean latentImageBean) {
        Input input = null;
        try{
            input = new Input(bytes);
            return kryo.readObject(input,latentImageBean.getClass());
        }finally {
            input.close();
        }
    }
}
