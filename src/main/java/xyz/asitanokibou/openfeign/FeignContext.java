package xyz.asitanokibou.openfeign;

import xyz.asitanokibou.cloud.named.NamedContextFactory;

public class FeignContext extends NamedContextFactory<FeignClientSpecification> {

	public FeignContext() {
		super(FeignClientsConfiguration.class, "feign", "feign.client.name");
	}

}
